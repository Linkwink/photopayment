/**
 * Created by Viacheslav_Khromoi on 12.08.2017.
 */
;(function () {
    'use strict';

    angular.module('app').factory('auxiliaryFieldModel', auxiliaryFieldModel);

    auxiliaryFieldModel.$inject = ['$resource', 'PostFile', 'apiPath'];

    function auxiliaryFieldModel($resource, PostFile, apiPath) {


        function create() {
            return {
                id : null,
                name: null,
                avatarPath: null
            }
        }

        function get(id) {
            return $resource(`${apiPath.root}/service-group/${id}`).get();
        }

        function getAll() {
            return $resource(`${apiPath.root}/service-group/all`).query();
        }

        function save(newGroup, file) {
            let formData = new FormData();
            if (file) {
                formData.append('avatar', file);
            }
            formData.append('name', newGroup.name);
            formData.append('avatarPath', newGroup.avatarPath);
            PostFile.setUrl(`${apiPath.root}/service-group/add`);
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