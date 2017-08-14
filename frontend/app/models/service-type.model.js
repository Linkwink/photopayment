/**
 * Created by Viacheslav_Khromoi on 12.08.2017.
 */
;(function () {
    'use strict';

    angular.module('app').factory('serviceTypeModel', serviceTypeModel);

    serviceTypeModel.$inject = ['$resource', 'PostFile', 'apiPath'];

    function serviceTypeModel($resource, PostFile, apiPath) {


        function create() {
            return {
                id: null,
                name: null,
                auxiliaryFields: null,
                serviceGroupId: null,
                serviceNomenklature : null
            }
        }

        function get(id) {
            return $resource(`${apiPath.root}/service-type/${id}`).get();
        }

        function getAll(id) {
            return $resource(`${apiPath.root}/service-type/all/${id}`).query();
        }

        function save(newType, file) {
            let formData = new FormData();
            if (file) {
                formData.append('avatar', file);
            }
            formData.append('name', newType.name);
            formData.append('auxiliaryFields', newType.auxiliaryFields);
            formData.append('serviceGroupId', newType.serviceGroupId);
            formData.append('serviceNomenklature', newType.serviceNomenklature);
            PostFile.setUrl(`${apiPath.root}/service-type/add`);
            return PostFile.withFile().send({}, formData).$promise;
        }

        return {
            create: create,
            get: get,
            getAll: getAll,
            save: save
        }
    }

})();