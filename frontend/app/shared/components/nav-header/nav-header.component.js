/**
 * Created by dn110592kvo on 08.08.2017.
 */
;(function () {

    'use strict'

    angular
        .module('app')
        .component('appNavHeader', {
            templateUrl: 'app/shared/components/nav-header/nav-header.template.html',
            controller: NavHeaderController,
            bindings: {
                title: '<',
                icon: '<'
            }
        });

    NavHeaderController.$inject = [];

    function NavHeaderController() {

    }

})();
