/**
 * Created by dn110592kvo on 07.08.2017.
 */
;(function () {

    "use strict";

    angular
        .module("app")
        .component("appRightBar", {
            templateUrl: "app/shared/components/rightbar/rightbar.template.html",
            controller: RightbarController,
        });

    RightbarController.$inject = ['userModel'];

    function RightbarController(userModel) {
        let vm = this;

        vm.model = {
            currentLanguage: "UA"
        }

    }

})();
