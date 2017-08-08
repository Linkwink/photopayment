/**
 * Created by dn110592kvo on 21.07.2017.
 */
const gulp = require('gulp');
const runSequence = require('run-sequence');
const del = require('del');
const $ = require('gulp-load-plugins')();
const pump = require('pump');
const argv = require('yargs').argv;
const browserSync = require('browser-sync').create();
const historyApiFallback = require('connect-history-api-fallback');
const imagemin = require('gulp-imagemin');

let values = (obj) => Object.keys(obj).map(key => obj[key]);

const path = {
    build: {
        root: './dist',
        style: './dist/css',
        js: './dist/js'
    },
    src: {
        modules: 'app/**/*.module.js',
        js: 'app/**/*.js',
        style: 'app/**/*.css',
        html: 'app/**/*.html',
        index: 'index.html'
    },
    watch: {
        html: 'app/**/*.html',
        js: 'app/**/*.js',
        style: 'app/**/*.css'
    },
    clean: './dist'
};

gulp.task('build', (callback) => runSequence( 'sass','generate-templates', 'pre_build', 'minify-img', callback));

gulp.task('browser', () =>
    browserSync.init({
        server: './dist',
        middleware: [ historyApiFallback() ],
        files: ['index.html', 'app/**/*']
    })
);

gulp.task('pre_build', () => {
    let filter = (path) => $.filter(path, { restore : true});

    const templates = gulp.src(`${path.build.js}/templates.js`, {read: false});
    const source = gulp.src(values(path.src), {read: false});

    revFilter = filter(['**/*.js','**/*.css', '!index.html']),
    cssFilter = filter('css/*.css'),
    jsFilter = filter('js/*.js'),
    jsFilterApp = filter('js/app.js');

    return gulp.src(path.src.index)
        .pipe($.inject(source))
        .pipe($.wiredep())
        .pipe($.useref())
        .pipe(revFilter).pipe($.rev())
        .pipe(revFilter.restore)
        .pipe($.revReplace())
        .pipe(jsFilterApp).pipe($.if(argv.minify, $.babel({presets: ['es2015']})))
        .pipe(jsFilterApp.restore)
        .pipe(jsFilter).pipe($.if(argv.minify, $.uglify()))
        .pipe(jsFilter.restore)
        .pipe(cssFilter)
        .pipe($.autoprefixer({
            browsers: ['last 2 versions'],
            cascade: false
        }))
        .pipe($.if(argv.minify, $.cleanCss({compatibility: 'ie8'})))
        .pipe(cssFilter.restore)
        .pipe($.inject(templates, { ignorePath: "dist", addRootSlash: false , name: 'template'}))
        .pipe(gulp.dest(path.build.root));
});

gulp.task('clean', callback => {
    del(path.build.root).then(() => {
        callback()
    });
});

gulp.task('sass', () =>
    gulp.src('./app/**/*.scss')
        .pipe($.sass().on('error', $.sass.logError))
        .pipe(gulp.dest('./app/'))
);

gulp.task('minify-img', () =>
    gulp.src('app/assets/**/*.png')
       .pipe(gulp.dest('./dist'))
);

gulp.task('generate-templates', () =>
    gulp.src(path.src.html)
        .pipe($.angularTemplatecache('templates.js', {module: 'app', transformUrl: (url) => `app/${url}`}))
        .pipe(gulp.dest(path.build.js))
);

gulp.task("vet", () =>
    gulp.src(path.src.js)
        .pipe(jshint({esversion: 6}))
        .pipe(jshint.reporter('default'))
        .pipe(jscs())
        .pipe(jscs.reporter())
);

gulp.task('watcher', () => gulp.watch(values(path.src), ['build']));