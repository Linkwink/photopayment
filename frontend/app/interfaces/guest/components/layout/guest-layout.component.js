/**
 * Created by dn110592kvo on 24.07.2017.
 */
;(function () {

    "use strict";

    angular
        .module("app")
        .component("appGuestLayout", {
            templateUrl: "app/interfaces/guest/components/layout/guest-layout.template.html",
            controller: GuestLayoutController,
        });

    GuestLayoutController.$inject = [];

    function GuestLayoutController() {
        let vm = this;


    }

})();
