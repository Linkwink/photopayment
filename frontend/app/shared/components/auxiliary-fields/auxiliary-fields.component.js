/**
 * Created by dn110592kvo on 19.08.2017.
 */
;(function () {

    'use strict';

    angular.module('app')
        .component('appAuxiliaryFields', {
            templateUrl: 'app/shared/components/auxiliary-fields/auxiliary-fields.template.html',
            controller: AuxiliaryFieldsController
        });

    function AuxiliaryFieldsController() {
        let vm = this;
    }

})();