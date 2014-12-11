[![Travis CI build status](https://travis-ci.org/bmuschko/grails-google-visualization.svg)](https://travis-ci.org/bmuschko/grails-google-visualization)
# Grails Google Visualization plugin

## Overview

The plugin provides a taglib for the interactive charts of the [Google Visualization API](https://developers.google.com/chart/interactive/docs/reference).
You can find the [full documentation](http://www.grails.org/plugin/google-visualization) including examples on the Grails plugin page.

## Features

* Supports all visualizations provided by Google.
* Implementations for table formatters `TableArrowFormat`, `TableBarFormat`, `TableColorFormat`, `TableDateFormat`, `TableNumberFormat` and `TablePatternFormat`.
* Visualization event handling.

## Change log

### version 0.7.2
- Fixes bug #32: the "error" event should be declared before drawing the chart.

### version 0.7.1
- Fixes bugs #28 and #24: Grails 2.3+ XSS prevention mechanism was HTML encoding the javascript output of the taglib and therefore breaking it.

## Development

To report issues or request improvements and new features please add a ticket in [Jira](http://jira.grails.org/browse/GPGOOGLEVISUALIZATIONAPI)
or open an issue on [GitHub](https://github.com/bmuschko/grails-google-visualization/issues). The plugin code gets built automatically
on [Travis CI](https://travis-ci.org/bmuschko/grails-google-visualization).
