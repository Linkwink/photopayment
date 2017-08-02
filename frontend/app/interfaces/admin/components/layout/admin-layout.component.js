/**
 * Created by dn110592kvo on 26.07.2017.
 */
;(function () {

    "use strict";

    angular
        .module("app")
        .component("appAdminLayout", {
            templateUrl: "app/interfaces/admin/components/layout/admin-layout.template.html",
            controller: AdminLayoutController,
        });

    AdminLayoutController.$inject = [];

    function AdminLayoutController() {
        let vm = this;


    }

})();
