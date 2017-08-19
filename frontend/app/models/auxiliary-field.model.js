/**
 * Created by Viacheslav_Khromoi on 12.08.2017.
 */
;(function () {
    'use strict';

    angular.module('app').factory('auxiliaryField', auxiliaryField);

    auxiliaryField.$inject = ['$resource', 'apiPath'];

    function auxiliaryField($resource, apiPath) {

        let root = `${apiPath.root}/auxiliary-field`;

        return $resource(root, {}, {
            save: { method : 'POST', url: `${root}/add`},
            getFieldTypes: { method: 'GET', url: `${root}/types/all`, isArray: true },
            getAll: { method: 'GET', url: `${root}/all`, isArray: true},
            search: { method: 'GET', url: `${root}/search/:pattern`, isArray: true, params: { pattern: '@pattern'}}
        });
    }

})();