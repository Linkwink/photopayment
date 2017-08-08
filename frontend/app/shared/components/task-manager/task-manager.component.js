/**
 * Created by dn110592kvo on 07.08.2017.
 */
;(function () {

    "use strict";

    angular
        .module("app")
        .component("appTaskManager", {
            templateUrl: "app/shared/components/task-manager/task-manager.template.html",
            controller: TaskManagerController
        });

    TaskManagerController.$inject = ['$rootScope'];

    function TaskManagerController($rootScope) {
        let vm = this;

        vm.model = {
        }
    }

})();
