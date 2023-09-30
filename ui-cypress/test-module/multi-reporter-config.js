module.exports = {
  reporterEnabled: "cypress-parallel/json-stream.reporter.js, cypress-parallel/simple-spec.reporter.js, mocha-junit-reporter, spec",
  cypressParallelSimpleSpecReporterJsReporterOptions: {
    reportDir: process.env.REPORTS_PATH || "cypress/results"
  },
  mochaJunitReporterReporterOptions: {
    mochaFile: `${process.env.REPORTS_PATH || "cypress/results"}/results-[hash].xml`
  }
};
