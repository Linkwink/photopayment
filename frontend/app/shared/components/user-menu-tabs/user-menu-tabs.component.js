/**
 * Created by dn110592kvo on 07.08.2017.
 */
;(function () {

    'use strict';

    angular
        .module('app')
        .component('appUserMenuTabs', {
            templateUrl: 'app/shared/components/user-menu-tabs/user-menu-tabs.template.html',
            controller: UserMenuTabsController,
        });

    UserMenuTabsController.$inject = ['userModel'];

    function UserMenuTabsController(userModel) {
        let vm = this;
        vm.model = {
            user: userModel.getUser()
        }

    }

})();
