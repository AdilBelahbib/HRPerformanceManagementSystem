 'use strict';

app
    .factory('Evaluation', function ($resource, $filter) {
        return $resource('/HRPerformanceManagementSystem/resources/evaluations/:id', {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    data = angular.fromJson(data);
                    return data;
                }
            },
            'ficheCouranteByCollaborateur' : { 
                        method: 'GET',
                        isArray: true,
                        url: '/HRPerformanceManagementSystem/resources/evaluations/ficheevaluationscourantes/collaborateur/:id'
                      },
            'collaborateur' : { 
                        method: 'GET',
                        isArray: true,
                        url: '/HRPerformanceManagementSystem/resources/evaluations/ficheevaluations/collaborateur/:id'
                      },
            'linkObjectifToProjet' : { 
                        method: 'GET',
                        isArray: true,
                        url: '/HRPerformanceManagementSystem/resources/evaluations/ficheevaluation/:idevaluation/:idficheevaluations'
                      },
            'addFiche' : { 
                        method: 'POST',
                        isArray: true,
                        url: '/HRPerformanceManagementSystem/resources/evaluations/ficheevaluations'
                      },
            'updateFiche' : { 
                        method: 'PUT',
                        isArray: true,
                        url: '/HRPerformanceManagementSystem/resources/evaluations/ficheevaluations/:id'
                      },
            'deleteFiche' : { 
                        method: 'DELETE',
                        isArray: true,
                        url: '/HRPerformanceManagementSystem/resources/evaluations/ficheevaluations/:id'
                      },
            'update': { method:'PUT' },
            
            'save': { method:'POST' }
        });
    });
