/**
 * Created by dn110592kvo on 26.07.2017.
 */
;(function () {

    'use strict';

    angular
        .module('app')
        .component('appSidenav', {
            templateUrl: 'app/shared/components/sidenav-menu/sidenav-menu.template.html',
            controller: SidenavController,
            bindings: {
                menuList: '<'
            }
        });

    SidenavController.$inject = ['appInfo'];

    function SidenavController(appInfo) {
        let vm = this;

        vm.model = {
            sidenavOpen: true,
            appName: appInfo.name
        }
    }

})();
