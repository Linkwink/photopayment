/**
 * Created by dn110592kvo on 17.08.2017.
 */
;(function () {

    'use strict';

    angular.module('app')
        .component('appAuxiliaryFieldsSettings', {
            templateUrl: 'app/shared/components/auxiliary-fields-settings/auxiliary-fields-settings.template.html',
            controller: AuxiliaryFieldsSettingsController
        });

    AuxiliaryFieldsSettingsController.$inject = [];

    function AuxiliaryFieldsSettingsController() {
        let vm = this;

        vm.menu = {

        }
    }


})();