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

        $urlRouterProvider.otherwise('/auth');


        $stateProvider
            .state('app', {
                abstract: true,
                data: {
                    authorizationRequired: true
                }
            })
            .state('auth', {
                url: '/auth',
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
            // ------------ ADMINISTRATOR STATES -------------------
            .state('app.administrator', {
                url: '/administrator',
                abstract: true,
                component: 'appAdminLayout',
                data: {
                    roleRequired: role.admin
                }
            })
            .state('app.administrator.layout', {
                url: '/',
                component: 'appDashboard'
            })
            .state('app.administrator.indicativeSettings', {
                url: '/indicative-settings',
                component: 'appIndicativeSettings'
            })
            .state('app.administrator.taskManager', {
                url: '/task-manager',
                component: 'appTaskManager'
            })
            .state('app.administrator.userManager', {
                url: '/user-manager',
                component: 'appUserManager'
            })
            .state('app.administrator.auxFields', {
                url: '/auxiliary-fields',
                component: 'appAuxiliaryFields',
                redirectTo: 'app.administrator.auxFields.layout'
            })
            .state('app.administrator.auxFields.layout', {
                url: '/',
                component: 'appAuxiliaryFieldsList'
            })
            .state('app.administrator.auxFields.new', {
                url: '/new',
                component: 'appAuxiliaryFieldNew'
            })
            // ------------ ADMINISTRATOR - SERVICE MANAGER STATES -------------------
            .state('app.administrator.serviceManager', {
                url: '/service',
                component: 'appServiceManager',
                redirectTo: 'app.administrator.serviceManager.layout'
            })
            .state('app.administrator.serviceManager.layout', {
                url: '/categories',
                component: 'appServiceCategoryList'
            })
            .state('app.administrator.serviceManager.serviceCategory', {
                url: '/categories',
                abstract: true,
                template: '<ui-view></ui-view>'
            })
            .state('app.administrator.serviceManager.serviceCategory.new', {
                url: '/new',
                component: 'appNewServiceCategory'
            })
            .state('app.administrator.serviceManager.categoryDetails', {
                url: '/categories/{categoryId:int}',
                abstract: true,
                template: '<ui-view class="anim-in-out anim-fade"></ui-view>',
            })
            .state('app.administrator.serviceManager.categoryDetails.layout', {
                url: '/',
                component: 'appServiceCategoryDetails'
            })
            .state('app.administrator.serviceManager.categoryDetails.new', {
                url: '/new',
                component: 'appNewServiceType'
            })


            // ------------ ACCOUNTANT STATES -------------------
            .state('app.accountant', {
                url: '/accountant',
                abstract: true,
                template: '<ui-view></ui-view>',
                data: {
                    roleRequired: role.accountant
                }
            })
            // ------------ MODERATOR STATES -------------------
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
            // ------------ MANAGER STATES -------------------
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

        $transitions.onSuccess({to: 'auth'}, function (trans) {
            let userModel = trans.injector().get('userModel'),
                user = userModel.getUser(),
                state = trans.router.stateService;

            function roleIncludes(role) {
                return user.roles.includes(role);
            }

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