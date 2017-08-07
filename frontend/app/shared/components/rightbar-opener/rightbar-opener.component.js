/**
 * Created by dn110592kvo on 07.08.2017.
 */
;(function () {

    "use strict";

    angular
        .module("app")
        .component("appRightBarOpener", {
            templateUrl: "app/shared/components/rightbar-opener/rightbar-opener.template.html",
            controller: RightBarOpenerController,
        });

    RightBarOpenerController.$inject = ['$mdSidenav'];

    function RightBarOpenerController($mdSidenav) {
        let vm = this;

        vm.model = {

        };
        
        vm.menu = {
            toggleRightBar: toggleRightBar  
        };
        
        
        function toggleRightBar() {
            return $mdSidenav('rightbar').toggle();
        }

    }

})();