/**
 * Created by dn110592kvo on 14.07.2017.
 */
;(function () {

    'use strict';

    angular
        .module('app')
        .config(themeConfig);

    themeConfig.$inject = ['$mdThemingProvider'];

    function themeConfig($mdThemingProvider) {
        $mdThemingProvider.theme('default')
            .primaryPalette('blue-grey')
            .accentPalette('grey')
            .backgroundPalette('grey');

    }


})();