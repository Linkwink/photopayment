/**
 * Created by dn110592kvo on 07.08.2017.
 */
;(function () {

    'use strict';

    angular
        .module('app')
        .component('appServiceManager', {
            templateUrl: 'app/shared/components/service-manager/service-manager.template.html',
            controller: ServiceManagerController
        });

    ServiceManagerController.$inject = [];

    function ServiceManagerController() {
        let vm = this;

        vm.model = {
        }
    }

})();
