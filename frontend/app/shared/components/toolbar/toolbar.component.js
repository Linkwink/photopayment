/**
 * Created by dn110592kvo on 26.07.2017.
 */
;(function () {

    'use strict';

    angular
        .module('app')
        .component('appToolbar', {
            templateUrl: 'app/shared/components/toolbar/toolbar.template.html',
            controller: AppToolbarController,
        });

    AppToolbarController.$inject = [];

    function AppToolbarController() {
        let vm = this;

        vm.model = {

        }

    }

})();