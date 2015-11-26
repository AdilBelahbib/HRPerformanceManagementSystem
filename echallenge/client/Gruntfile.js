module.exports = function(grunt) {

  // Configuration de Grunt
  grunt.initConfig({
  	concat: {
      options: {
        separator: ';', // permet d'ajouter un point-virgule entre chaque fichier concaténé.
      },
      dist: {
        src: ['scripts/**/*.js'], // la source
        dest: 'dist/app.js' // la destination finale
      }
    },
    
    uglify: {
    build: {
        src: 'dist/app.js',
        dest: 'dist/app.min.js'
    }
	},
	injector: {
    options: {},
    local_dependencies: {
      files: {
        'index.html': ['scripts/**/*.js', 'assets/css/*.css'],
      }
    }
  },
  wiredep: {

  task: {

    // Point to the files that should be updated when
    // you run `grunt wiredep`
    src: [
      'index.html'
    ],

    options: {
      // See wiredep's configuration documentation for the options
      // you may pass:

      // https://github.com/taptapship/wiredep#configuration
    }
  }
}

  })

  // Définition des tâches Grunt
  grunt.loadNpmTasks('grunt-contrib-concat');
  grunt.loadNpmTasks('grunt-contrib-uglify');
  grunt.loadNpmTasks('grunt-asset-injector');
  grunt.loadNpmTasks('grunt-wiredep');


  grunt.registerTask('build', ['concat','uglify']);
  
  grunt.registerTask('dependencies', ['injector']);


}