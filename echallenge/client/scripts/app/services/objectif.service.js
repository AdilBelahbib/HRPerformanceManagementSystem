'use strict';

app
    .factory('Objectif', function ($resource, $filter) {
        return $resource('http://localhost:8080/HRPerformanceManagementSystem/resources/objectifs/:id', {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    data = angular.fromJson(data);
                    return data;
                }
            },
            'update': { method:'PUT' },
            'currentfiche': { 
                        method: 'GET',
                        isArray: false,
                        
                        url: 'http://localhost:8080/HRPerformanceManagementSystem/resources/objectifs/ficheobjectifscourants/bycollaborateur/:id'
                      },
            'save': { method:'POST' }
        });
    });
