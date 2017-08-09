/**
 * Created by dn110592kvo on 09.08.2017.
 */
;(function () {

    'use strict';

    angular.module('app').factory('XSRFInterceptor', XSRFInterceptor);

    XSRFInterceptor.$inject = ['$cookies'];

    function XSRFInterceptor($cookies) {

        let XSRFInterceptor = {

            request: function(config) {
                let token = $cookies.get('XSRF-TOKEN');
                if (token) {
                    config.headers['X-XSRF-TOKEN'] = token;
                }
                return config;
            }
        };
        return XSRFInterceptor;
    }

})();