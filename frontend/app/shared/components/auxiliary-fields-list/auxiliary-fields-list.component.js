/**
 * Created by dn110592kvo on 17.08.2017.
 */
;(function () {

    'use strict';

    angular.module('app')
        .component('appAuxiliaryFieldsList', {
            templateUrl: 'app/shared/components/auxiliary-fields-list/auxiliary-fields-list.template.html',
            controller: AuxiliaryFieldsListController
        });

    AuxiliaryFieldsListController.$inject = ['auxiliaryField'];

    function AuxiliaryFieldsListController(auxiliaryField) {
        let vm = this;

        vm.model = {
            fields: auxiliaryField.getAll(),
            table: {
                selected: [],
                query: {
                    order: 'id',
                    limit: 5,
                    page: 1
                },
                paginationTranslate: {
                    ua: {
                        page: 'Страница:',
                        rowsPerPage: 'Строк на странице:',
                        of: 'с'
                    },
                    ru: {
                        page: 'Сторінка:',
                        rowsPerPage: 'Рядків на сторінці:',
                        of: 'з'
                    }
                },
                tableConfig: {
                    //table pagination rows per page count
                    limitOptions: [10, 25, 50, {
                        label: 'All',
                        value: function () {
                            return vm.model.fields.length;
                        }
                    }],
                    //table pagination query param
                    query: {
                        page: 1,
                        limit: 10
                    }
                }
            }
        }

    }

})();