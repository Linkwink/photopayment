/**
 * Created by dn110592kvo on 07.08.2017.
 */
;(function () {

    'use strict';

    angular
        .module('app')
        .component('appDashboard', {
            templateUrl: 'app/shared/components/dashboard/dashboard.template.html',
            controller: DashboardController,
        });

    DashboardController.$inject = [];

    function DashboardController() {
        let vm = this;

    }

})();