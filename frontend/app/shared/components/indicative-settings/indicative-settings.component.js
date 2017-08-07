/**
 * Created by dn110592kvo on 07.08.2017.
 */
;(function () {

    'use strict'

    angular
        .module('app')
        .component('appIndicativeSettings', {
            templateUrl: 'app/shared/components/indicative-settings/indicative-settings.template.html',
            controller: IndicativeSettingsController,
        });

    IndicativeSettingsController.$inject = [];

    function IndicativeSettingsController() {
        let vm = this;

        vm.model = {
        }

    }

})();
