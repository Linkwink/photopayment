/**
 * Created by dn110592kvo on 07.08.2017.
 */
;(function () {

    "use strict";

    angular
        .module("app")
        .component("appUserManager", {
            templateUrl: "app/shared/components/user-manager/user-manager.template.html",
            controller: UserManagerController
        });

    UserManagerController.$inject = [];

    function UserManagerController() {
        let vm = this;

        vm.model = {
        }
    }

})();
