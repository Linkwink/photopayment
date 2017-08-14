/**
 * Created by Viacheslav_Khromoi on 12.08.2017.
 */
;(function () {
    'use strict';

    angular.module('app').factory('auxiliaryFieldTypeModel', auxiliaryFieldTypeModel);

    auxiliaryFieldTypeModel.$inject = ['$resource', 'apiPath'];

    function auxiliaryFieldTypeModel($resource, apiPath) {

        function getAll() {
            return $resource(`${apiPath.root}/auxiliary-field/types/all`).query();
        }

        return {
            getAll: getAll
        }
    }

})();