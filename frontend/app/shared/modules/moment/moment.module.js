/**
 * Created by dn110592kvo on 18.07.2017.
 */
;(function () {
    'use strict';

    angular
        .module('momentJS', [])
        .factory('moment', function ($window) {
            return $window.moment;
        });
})();
