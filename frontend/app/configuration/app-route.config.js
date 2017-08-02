/**
 * Created by dn110592kvo on 14.07.2017.
 */
;(function () {

    "use strict";

    angular
        .module("app")
        .config(routeConfig)
        .run(routeRun);

    routeConfig.$inject = ['$stateProvider', '$locationProvider', '$urlRouterProvider', 'role'];

    routeRun.$inject = ['$transitions', 'role'];


    function routeConfig($stateProvider, $locationProvider, $urlRouterProvider, role) {

        $locationProvider.html5Mode(true);

        $urlRouterProvider.otherwise('/proxy');

        $stateProvider
            .state('app', {
                abstract: true,
                data: {
                    authorizationRequired: true
                }
            })
            .state('proxy', {
                url: '/proxy',
                template: '<ui-view></ui-view>',
                data: {
                    authorizationRequired: true
                }
            })
            .state('login', {
                url: '/login',
                resolve: {
                    mdDialog: (mdDialog) => mdDialog
                },
                data: {
                    authorizationRequired: false
                },
                onEnter: (mdDialog) => mdDialog.showAuthorizeModal()
            })
            .state('welcome', {
                parent: 'app',
                url: '/welcome',
                component: 'welcome',
            })
            .state('app.administrator', {
                url: '/administrator',
                abstract: true,
                template: '<ui-view></ui-view>',
                data: {
                    roleRequired: role.admin
                }
            })
            .state('app.administrator.layout', {
                url: '/',
                component: 'appAdminLayout'
            })
            .state('app.accountant', {
                url: '/accountant',
                abstract: true,
                template: '<ui-view></ui-view>',
                data: {
                    roleRequired: role.accountant
                }
            })
            .state('app.moderator', {
                url: '/moderator',
                abstract: true,
                template: '<ui-view></ui-view>',
                data: {
                    roleRequired: role.moderetor
                }
            })
            .state('app.moderator.layout', {
                url: '/',
                component: 'appModeratorLayout'
            })
            .state('app.manager', {
                url: '/manager',
                abstract: true,
                template: '<ui-view></ui-view>',
                data: {
                    roleRequired: role.manager
                }
            });
    }

    function routeRun($transitions, role) {

        $transitions.onSuccess({to: 'proxy'}, function (trans) {
            let userModel = trans.injector().get('userModel'),
                user = userModel.getUser(),
                state = trans.router.stateService;

            function roleIncludes(role) {
                return user.roles.includes(role);
            }
            debugger;
            if (roleIncludes(role.admin)) {
                state.transitionTo('app.administrator.layout');
            } else if (roleIncludes(role.manager)) {
                state.transitionTo('login');
            } else if (roleIncludes(role.accountant)) {
                state.transitionTo('login');
            } else if (roleIncludes(role.moderetor)) {
                state.transitionTo('app.moderator.layout');
            } else if (roleIncludes(role.guest)) {
                state.transitionTo('welcome');
            }

        });

        $transitions.onStart({to: pathRoleMatcher}, function (trans) {
            let userModel = trans.injector().get('userModel'),
                user = userModel.getUser(),
                target = trans.$to();

            if (user.roles.includes(target.data.roleRequired)) {
                return true;
            } else {
                trans.router.stateService.transitionTo('proxy');
                return false;
            }
        });

        $transitions.onBefore({to: pathAuthMatcher}, function (trans) {
            let authorization = trans.injector().get('authorization');

            return authorization
                .isAuthorized()
                .then((isAuthorized) => {
                    if (!isAuthorized) {
                        trans.router.stateService.transitionTo('login');
                    }
                    return isAuthorized;
                });
        });

    }


    function pathRoleMatcher(state) {
        return state.data != null && state.data.roleRequired != null;
    }

    function pathAuthMatcher(state) {
        return state.data != null && (state.data.authorizationRequired === true || ( state.parent.data != null && state.parent.data.authorizationRequired === true ));
    }

})();