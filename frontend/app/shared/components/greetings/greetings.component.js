/**
 * Created by dn110592kvo on 26.07.2017.
 */
;(function () {

    "use strict";

    angular
        .module("app")
        .component("appGreetings", {
            templateUrl: "app/shared/components/greetings/greetings.template.html",
            controller: GreetingsController,
        });


    function GreetingsController() {
        let vm = this;

        vm.model = {

        }

    }

})();
