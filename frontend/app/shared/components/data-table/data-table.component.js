/**
 * Created by dn110592kvo on 19.08.2017.
 */
;(function () {

    'use strict';

    angular
        .module('app')
        .component('appDataTable', {
            templateUrl: 'app/shared/components/data-table/data-table.template.html',
            controller: DataTableController,
            bindings: {
                tableData: "="
            }
        });

    DataTableController.$inject = [];

    function DataTableController() {
        let vm = this;

        vm.model = {

        }

    }

})();
