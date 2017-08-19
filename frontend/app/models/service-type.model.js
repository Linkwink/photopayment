/**
 * Created by Viacheslav_Khromoi on 12.08.2017.
 */
;(function () {
    'use strict';

    angular.module('app').factory('serviceType', serviceType);

    serviceType.$inject = ['$resource', 'apiPath'];

    function serviceType($resource, apiPath) {

        let root = `${apiPath.root}/service-type`;
        return $resource(root, {}, {
            save: {
                method: 'POST',
                url: `${root}/add`,
                headers: {'Content-Type': undefined},
                transformRequest: (data) => {
                    let transformed = new FormData();
                    transformed.append('serviceType', JSON.stringify({id: null, name: data.name, auxiliaryFields: data.auxiliaryFields, serviceGroupId: data.serviceGroupId, serviceNomenklature: data.serviceNomenklature}));
                    transformed.append('avatar', data.file.shift().lfFile);
                    return transformed;
                }
            },
            get: {method: 'GET', url: `${root}/:id`, params: {id: '@id'}},
            getFieldTypes: {method: 'GET', url: `${root}/types/all`, isArray: true},
            getAll: {method: 'GET', url: `${root}/all/:id`, isArray: true,  params: {id: '@id'}}
        });
    }

})();