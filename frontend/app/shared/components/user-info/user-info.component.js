/**
 * Created by dn110592kvo on 24.07.2017.
 */
;(function () {

    "use strict";

    angular
        .module("app")
        .component("appUserInfo", {
            templateUrl: "app/shared/components/user-info/user-info.template.html",
            controller: UserInfoController,
        });

    UserInfoController.$inject = ['userModel'];

    function UserInfoController(userModel) {
        let vm = this;
        console.log(true);
        vm.model = {
            user: userModel.getUser()
        }

    }

})();
