/**
 * Created by dn110592kvo on 19.08.2017.
 */
;(function () {

    'use strict';

    angular.module('app')
        .component('appAuxiliaryFieldsSelector', {
            templateUrl: 'app/shared/components/auxiliary-fields-selector/auxiliary-fields-selector.template.html',
            controller: AuxiliaryFieldsSelectorController,
            bindings: {
                selectedFields: '='
            }
        });

    AuxiliaryFieldsSelectorController.$inject = ['auxiliaryField'];

    function AuxiliaryFieldsSelectorController(auxiliaryField) {
        let vm = this;

        vm.model = {
            selectedFields: [],
            selectedItem: null,
            searchText: '',
        };

        vm.actions = {
            querySearch: querySearch
        };

        function querySearch(searchText) {
            return auxiliaryField.search({ pattern: searchText}).$promise;
        }


    }

})();