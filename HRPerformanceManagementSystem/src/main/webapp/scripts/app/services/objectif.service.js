'use strict';

app
.factory('Objectif', function ($resource, $filter) {
  return $resource('/HRPerformanceManagementSystem/resources/objectifs/:id', {}, {
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

      url: '/HRPerformanceManagementSystem/resources/objectifs/ficheobjectifscourants/collaborateur/:id'
    },
    'ficheEnCours' : {
      method :'GET',
      isArray : false,
      url: '/HRPerformanceManagementSystem/resources/objectifs/ficheobjectifs/encours/:id'
    },

    'collaborateur': { 
      method: 'GET',
      isArray: false,

      url: '/HRPerformanceManagementSystem/resources/objectifs/ficheobjectifs/collaborateur/:id'
    },
    'linkToFiche':
    { 
      method: 'GET',
      isArray: false,
      url: '/HRPerformanceManagementSystem/resources/objectifs/link/ficheobjectifs/:idobjectif/:idficheobjectif'
    },
    'linkToFormation':
    { 
      method: 'GET',
      isArray: false,
      url: '/HRPerformanceManagementSystem/resources/objectifs/link/formation/:idobjectif/:idformation'
    },
    'linkToEncadrant':
    {
      method: 'GET',
      isArray: false,
      url: '/HRPerformanceManagementSystem/resources/objectifs/link/encadrant/:idObjectif/:idencadrant'
    },
    'linkToProject':
    { 
      method: 'GET',
      isArray: false,
      url: '/HRPerformanceManagementSystem/resources/objectifs/link/projet/:idobjectif/:idprojet'
    },

    'addFiche':
    { 
      method: 'POST',
      url: '/HRPerformanceManagementSystem/resources/objectifs/ficheobjectifs'
    },
    'updateFiche':
    { 
      method: 'PUT',
      url: '/HRPerformanceManagementSystem/resources/objectifs/ficheobjectifs/:id'
    },
    'deleteFiche':
    { 
      method: 'DELETE',
      url: '/HRPerformanceManagementSystem/resources/objectifs/ficheobjectifs/:id'
    },
    'save': { method:'POST' }
  });
});
