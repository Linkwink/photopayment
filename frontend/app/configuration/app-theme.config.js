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

        $mdThemingProvider
            .definePalette('customPalette', {
                '50': '#FFFFFF',
                '100': '#B2DFDB',
                '200': '#80CBC4',
                '300': '#46BE8A',
                '400': '#46BE8A',
                '500': '#46BE8A',
                '600': '#46BE8A',
                '700': '#00897B',
                '800': '#00796B',
                '900': '#00695C',
                'A100': '#A7FFEB',
                'A200': '#37474F',
                'A400': '#F44336',
                'A700': '#546E7A',
                'contrastDefaultColor': 'light',    // whether, by default, text (contrast)
                // on this palette should be dark or light
                'contrastDarkColors': ['50', '100', //hues which contrast should be 'dark' by default
                    '200', '300', '400', 'A100'],
                'contrastLightColors': undefined
            })
            .theme('default')
            .primaryPalette("customPalette", {
                'hue-1': '900', // use shade 100 for the <code>md-hue-1</code> class
                'hue-2': 'A700', // use shade 600 for the <code>md-hue-2</code> class
                'hue-3': '50' // use shade A100 for the <code>md-hue-3</code> class
            })
            .accentPalette("blue-grey");

    }


})();