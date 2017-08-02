/**
 * Created by dn110592kvo on 21.07.2017.
 */
const gulp = require('gulp');
const concat = require('gulp-concat');
const del = require('del');
const sass = require('gulp-sass');
const $ = require('gulp-load-plugins')();



gulp.task('build', ['sass','copy-templates'], function() {

    const source = gulp.src(['app/**/*.module.js', 'app/**/*.js', 'app/**/*.css'], {read: false});

    return gulp.src('index.html')
        .pipe($.inject(source))
        .pipe($.wiredep())
        .pipe($.useref())
        .pipe(gulp.dest('./dist'));
});

gulp.task('copy-templates', function() {
    return gulp.src('app/**/*.html')
        .pipe(gulp.dest('./dist/app'));
});

gulp.task('vet', function() {
    return gulp.src('app/**/*.js')
        .pipe($.jshint({esversion: 6}))
        .pipe($.jshint.reporter('default'))
        .pipe($.jscs())
        .pipe($.jscs.reporter());
});


gulp.task('sass', function () {
    return gulp.src('app/assets/scss/**/*.scss')
        .pipe(sass().on('error', sass.logError))
        .pipe(gulp.dest('app/assets/css'));
});


gulp.task('watcher', function() {
    return gulp.watch(['app/**/*.js','app/**/*.html','app/**/*.scss'], ['build']);
});

gulp.task('clean', function (callback) {
    del(['dist']).then(() => { callback() });
});