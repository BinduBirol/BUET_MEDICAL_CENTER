<%@include file="/WEB-INF/jsp/template/head.jsp" %>

    <link rel="stylesheet" href="/MCENTER/css/table1.css" type="text/css"></link>
    <link rel="stylesheet" href="/MCENTER/resources/css/style/tablecss.css" type="text/css"></link>
    <link rel="stylesheet" href="/MCENTER/js/jquery.validity.1.2.0/jquery.validity.css" type="text/css"></link>
    <script type="text/javascript" src="/MCENTER/js/jquery.validity.1.2.0/jQuery.validity.js"></script>

    <title>BUET Medical Center</title>
    <link type="image/x-icon" rel="icon" href="resource/img/logo.png" />
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">
    <link rel="stylesheet" href="resource/css/main.css" type="text/css" />
    <script type="text/javascript" src="resource/js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="resource/js/functions.js"></script>

    <link rel="stylesheet" href="css/table1.css" type="text/css" />
    <link rel="stylesheet" href="css/jquery-ui.css" type="text/css" />

    <script src="js/jQuery.js" type="text/javascript"></script>
    <script src="js/jquery1.4.4min.js"></script>
    <script src="js/jquery.min.js"></script>
    <script src="js/jquery-1.10.2.js"></script>
    <script src="js/jquery-ui.js"></script>
    <script src="js/highcharts.js"></script>
    <script src="js/data.js"></script>
    <script src="js/exporting.js"></script>
    <link rel="stylesheet" href="js/jquery.validity.1.2.0/jquery.validity.css" type="text/css"></link>
    <script type="text/javascript" src="js/jquery.validity.1.2.0/jQuery.validity.js"></script>
    <link href="css/button.css" type="text/css" rel="stylesheet" />

    <script type="text/javascript">
        $(function() {
            $('#container').highcharts({
                data: {
                    table: document.getElementById('datatable')

                },
                chart: {
                    type: 'column'
                },
                title: {
                    text: 'Number of patients treated by daily doctor'
                },

                colors: [
                    '#3290CF'
                ],

                yAxis: {
                    allowDecimals: false,
                    title: {
                        text: 'Patient Numbers '
                    }
                },
                tooltip: {
                    formatter: function() {
                        return '<b>' + this.series.name + '</b><br/>' +
                            this.point.y + ' ' + this.point.name.toLowerCase();
                    }
                }
            });
        });
    </script>

    <script>
        $(function() {
            $("#fromdatepicker").datepicker({
                dateFormat: 'dd/mm/yy',
                changeMonth: true,
     	        changeYear: true
            }).val();

            $("#todatepicker").datepicker({
                dateFormat: 'dd/mm/yy',
                changeMonth: true,
     	        changeYear: true
            }).val();
        });
    </script>

    <script language="javascript">
        $(function() {

            $("form").validity(function() {
                $("#fromdatepicker")
                    .require()
                    .match("date");

                $("#todatepicker")
                    .require()
                    .match("date");
            });

        });
    </script>

    <style type="text/css" media="screen">
        .additionForm {
            background-color: #F0F5F4;
            width: 300px;
            padding: 10px 30px;
            font-family: arial;
            font-size: 12px;
            border-color: #999999;
            margin: 0 auto;
        }
    </style>

    <!--Main content will be here-->

    <div align="center"><h1 align=c enter><font size="5" color="red">Number of patient served by individual doctor</font></h1>	</div>

    <fieldset class="additionForm">

        <legend>Select date and shift</legend>

        <s:form action="dailydoctorVSpatientchartaction">
            <table align="center" style="border-spacing: 4px;">

<%--                 <tr>
                    <td>
                        <s:select id="shift" name="shift" list="{'9-12 AM','4-6  PM'}" label="Shift" theme="xhtml" />

                    </td>
                </tr>
 --%>
                <tr>
                    <td>
                        <s:textfield label="From Date" id="fromdatepicker" name="fdate" size="8" theme="xhtml" />

                    </td>
                </tr>

                <tr>
                    <td>
                        <s:textfield label="To Date" id="todatepicker" name="tdate" size="8" theme="xhtml" />

                    </td>
                </tr>

                <tr>
                    <td>
                        &nbsp;
                    </td>
                    <td>
                        <s:submit id="search" value="Search" theme="simple" align="center" cssClass="btn btn-primary btn-large" />
                        <s:reset value="Clear" theme="simple" cssClass="btn btn-small" align="center" />

                    </td>
                </tr>

            </table>

        </s:form>
    </fieldset>

    <div style="width:300px;" align="right">
        <table id="datatable" border="1" class="bordered">
            <thead>
                <tr>

                    <th>Doctor</th>
                    <th>Patient</th>

                </tr>
            </thead>
            <tbody>

                <s:iterator value="dailydoctorlist">
                    <tr>
                        <td><s:property value="doctor" />
                        </td>
                        <td><s:property value="patientNumber" />
                        </td>

                    </tr>

                </s:iterator>

            </tbody>
        </table>
    </div>

    <center>

        <div>

            <div id="container" style="min-width: 310px; width:600px; height: 400px; margin: 0 auto" data-highcharts-chart="0">
                <div class="highcharts-container" id="highcharts-0" style="position: relative; overflow: hidden; width: 1008px; height: 400px; text-align: left; line-height: normal; z-index: 0; -webkit-tap-highlight-color: rgba(0, 0, 0, 0);">
                    <svg version="1.1" style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Arial, Helvetica, sans-serif;font-size:12px;" xmlns="http://www.w3.org/2000/svg" width="1008" height="400">
                        <desc>Created with Highcharts 4.0.1</desc>
                        <defs>
                            <clippath id="highcharts-1">
                                <rect x="0" y="0" width="933" height="276"></rect>
                            </clippath>
                        </defs>
                        <rect x="0" y="0" width="1008" height="400" strokeWidth="0" fill="#FFFFFF" class=" highcharts-background"></rect>
                        <g class="highcharts-button" style="cursor:default;" stroke-linecap="round" transform="translate(974,10)">
                            <title>Chart context menu</title>
                            <rect x="0.5" y="0.5" width="24" height="22" strokeWidth="1" fill="white" stroke-width="1" stroke="none" rx="2" ry="2">
                            </rect>
                            <path fill="#E0E0E0" d="M 6 6.5 L 20 6.5 M 6 11.5 L 20 11.5 M 6 16.5 L 20 16.5" stroke="#666" stroke-width="3" zIndex="1">
                            </path>
                            <text x="0" zIndex="1" style="color:black;fill:black;" y="13"></text>
                        </g>
                        <g class="highcharts-grid" zIndex="1"></g>
                        <g class="highcharts-grid" zIndex="1">
                            <path fill="none" d="M 65 46.5 L 998 46.5" stroke="#C0C0C0" stroke-width="1" zIndex="1" opacity="1"></path>
                            <path fill="none" d="M 65 93.5 L 998 93.5" stroke="#C0C0C0" stroke-width="1" zIndex="1" opacity="1"></path>
                            <path fill="none" d="M 65 139.5 L 998 139.5" stroke="#C0C0C0" stroke-width="1" zIndex="1" opacity="1"></path>
                            <path fill="none" d="M 65 185.5 L 998 185.5" stroke="#C0C0C0" stroke-width="1" zIndex="1" opacity="1"></path>
                            <path fill="none" d="M 65 231.5 L 998 231.5" stroke="#C0C0C0" stroke-width="1" zIndex="1" opacity="1"></path>
                            <path fill="none" d="M 65 277.5 L 998 277.5" stroke="#C0C0C0" stroke-width="1" zIndex="1" opacity="1"></path>
                            <path fill="none" d="M 65 323.5 L 998 323.5" stroke="#C0C0C0" stroke-width="1" zIndex="1" opacity="1"></path>
                        </g>
                        <g class="highcharts-axis" zIndex="2">
                            <path fill="none" d="M 437.5 323 L 437.5 333" stroke="#C0D0E0" stroke-width="1" opacity="1"></path>
                            <path fill="none" d="M 624.5 323 L 624.5 333" stroke="#C0D0E0" stroke-width="1" opacity="1"></path>
                            <path fill="none" d="M 810.5 323 L 810.5 333" stroke="#C0D0E0" stroke-width="1" opacity="1"></path>
                            <path fill="none" d="M 997.5 323 L 997.5 333" stroke="#C0D0E0" stroke-width="1" opacity="1"></path>
                            <path fill="none" d="M 251.5 323 L 251.5 333" stroke="#C0D0E0" stroke-width="1" opacity="1"></path>
                            <path fill="none" d="M 64.5 323 L 64.5 333" stroke="#C0D0E0" stroke-width="1" opacity="undefined"></path>
                            <path fill="none" d="M 65 323.5 L 998 323.5" stroke="#C0D0E0" stroke-width="1" zIndex="7" visibility="visible"></path>
                        </g>
                        <g class="highcharts-axis" zIndex="2">
                            <text x="26" zIndex="7" text-anchor="middle" transform="translate(0,0) rotate(270 26 185)" class=" highcharts-yaxis-title" style="color:#707070;fill:#707070;" visibility="visible" y="185">Units</text>
                        </g>
                        <g class="highcharts-series-group" zIndex="3">
                            <g class="highcharts-series highcharts-tracker" visibility="visible" zIndex="0.1" transform="translate(65,47) scale(1 1)" style="" clip-path="url(#highcharts-1)">
                                <rect x="42.5" y="207.5" width="45" height="69" stroke="#FFFFFF" fill="#434348" rx="0" ry="0" stroke-width="1">
                                </rect>
                                <rect x="229.5" y="230.5" width="45" height="46" stroke="#FFFFFF" fill="#434348" rx="0" ry="0" stroke-width="1">
                                </rect>
                                <rect x="415.5" y="161.5" width="45" height="115" stroke="#FFFFFF" fill="#434348" rx="0" ry="0" stroke-width="1"></rect>
                                <rect x="602.5" y="253.5" width="45" height="23" stroke="#FFFFFF" fill="#434348" rx="0" ry="0" stroke-width="1"></rect>
                                <rect x="788.5" y="230.5" width="45" height="46" stroke="#FFFFFF" fill="#434348" rx="0" ry="0" stroke-width="1"></rect>
                            </g>
                            <g class="highcharts-markers" visibility="visible" zIndex="0.1" transform="translate(65,47) scale(1 1)" clip-path="none"></g>
                            <g class="highcharts-series highcharts-tracker" visibility="visible" zIndex="0.1" transform="translate(65,47) scale(1 1)" style="" clip-path="url(#highcharts-1)">
                                <rect x="98.5" y="184.5" width="45" height="92" stroke="#FFFFFF" fill="#434348" rx="0" ry="0" stroke-width="1"></rect>
                                <rect x="284.5" y="276.5" width="45" height="0" stroke="#FFFFFF" fill="#434348" rx="0" ry="0" stroke-width="1"></rect>
                                <rect x="471.5" y="23.5" width="45" height="253" stroke="#FFFFFF" fill="rgba(92,92,97,1)" rx="0" ry="0" stroke-width="1"></rect>
                                <rect x="658.5" y="253.5" width="45" height="23" stroke="#FFFFFF" fill="#434348" rx="0" ry="0" stroke-width="1"></rect>
                                <rect x="844.5" y="184.5" width="45" height="92" stroke="#FFFFFF" fill="#434348" rx="0" ry="0" stroke-width="1"></rect>
                            </g>
                            <g class="highcharts-markers" visibility="visible" zIndex="0.1" transform="translate(65,47) scale(1 1)" clip-path="none"></g>
                        </g>
                        <text x="504" text-anchor="middle" class="highcharts-title" zIndex="4" style="color:#333333;font-size:18px;fill:#333333;width:944px;" y="25">
                            <tspan>Number of patient treated by daily doctor</tspan>
                        </text>
                        <g class="highcharts-legend" zIndex="7" transform="translate(440,366)">
                            <g zIndex="1">
                                <g>
                                    <g class="highcharts-legend-item" zIndex="1" transform="translate(8,3)">
                                        <text x="21" y="15" style="color:#333333;font-size:12px;font-weight:bold;cursor:pointer;fill:#333333;" text-anchor="start" zIndex="2">Jane</text>
                                        <rect x="0" y="4" width="16" height="12" zIndex="3" fill="#7cb5ec"></rect>
                                    </g>
                                    <g class="highcharts-legend-item" zIndex="1" transform="translate(78,3)">
                                        <text x="21" y="15" style="color:#333333;font-size:12px;font-weight:bold;cursor:pointer;fill:#333333;" text-anchor="start" zIndex="2">John</text>
                                        <rect x="0" y="4" width="16" height="12" zIndex="3" fill="#434348"></rect>
                                    </g>
                                </g>
                            </g>
                        </g>
                        <g class="highcharts-axis-labels highcharts-xaxis-labels" zIndex="7">
                            <text x="158.3" text-anchor="middle" style="width:167px;color:#606060;cursor:default;font-size:11px;fill:#606060;" y="343" opacity="1">Apples</text>
                            <text x="344.9" text-anchor="middle" style="width:167px;color:#606060;cursor:default;font-size:11px;fill:#606060;" y="343" opacity="1">Pears</text>
                            <text x="531.5" text-anchor="middle" style="width:167px;color:#606060;cursor:default;font-size:11px;fill:#606060;" y="343" opacity="1">Plums</text>
                            <text x="718.1" text-anchor="middle" style="width:167px;color:#606060;cursor:default;font-size:11px;fill:#606060;" y="343" opacity="1">Bananas</text>
                            <text x="904.6999999999999" text-anchor="middle" style="width:167px;color:#606060;cursor:default;font-size:11px;fill:#606060;" y="343" opacity="1">Oranges</text>
                        </g>
                        <g class="highcharts-axis-labels highcharts-yaxis-labels" zIndex="7">
                            <text x="50" text-anchor="end" style="width:313px;color:#606060;cursor:default;font-size:11px;fill:#606060;" y="327.5" opacity="1">0</text>
                            <text x="50" text-anchor="end" style="width:313px;color:#606060;cursor:default;font-size:11px;fill:#606060;" y="281.5" opacity="1">2</text>
                            <text x="50" text-anchor="end" style="width:313px;color:#606060;cursor:default;font-size:11px;fill:#606060;" y="235.5" opacity="1">4</text>
                            <text x="50" text-anchor="end" style="width:313px;color:#606060;cursor:default;font-size:11px;fill:#606060;" y="189.5" opacity="1">6</text>
                            <text x="50" text-anchor="end" style="width:313px;color:#606060;cursor:default;font-size:11px;fill:#606060;" y="143.5" opacity="1">8</text>
                            <text x="50" text-anchor="end" style="width:313px;color:#606060;cursor:default;font-size:11px;fill:#606060;" y="97.5" opacity="1">10</text>
                            <text x="50" text-anchor="end" style="width:313px;color:#606060;cursor:default;font-size:11px;fill:#606060;" y="51.5" opacity="1">12</text>
                        </g>
                        <g class="highcharts-tooltip" zIndex="8" style="cursor:default;padding:0;white-space:nowrap;" transform="translate(524,16)" opacity="1" visibility="visible">
                            <path fill="none" d="M 3.5 0.5 L 68.5 0.5 C 71.5 0.5 71.5 0.5 71.5 3.5 L 71.5 45.5 C 71.5 48.5 71.5 48.5 68.5 48.5 L 41.528874324713456 48.5 35.528874324713456 54.5 29.528874324713456 48.5 3.5 48.5 C 0.5 48.5 0.5 48.5 0.5 45.5 L 0.5 3.5 C 0.5 0.5 0.5 0.5 3.5 0.5"
                            stroke-width="5" isShadow="true" stroke="black" stroke-opacity="0.049999999999999996" transform="translate(1, 1)" width="71" height="48"></path>
                            <path fill="none" d="M 3.5 0.5 L 68.5 0.5 C 71.5 0.5 71.5 0.5 71.5 3.5 L 71.5 45.5 C 71.5 48.5 71.5 48.5 68.5 48.5 L 41.528874324713456 48.5 35.528874324713456 54.5 29.528874324713456 48.5 3.5 48.5 C 0.5 48.5 0.5 48.5 0.5 45.5 L 0.5 3.5 C 0.5 0.5 0.5 0.5 3.5 0.5"
                            stroke-width="3" isShadow="true" stroke="black" stroke-opacity="0.09999999999999999" transform="translate(1, 1)" width="71" height="48"></path>
                            <path fill="none" d="M 3.5 0.5 L 68.5 0.5 C 71.5 0.5 71.5 0.5 71.5 3.5 L 71.5 45.5 C 71.5 48.5 71.5 48.5 68.5 48.5 L 41.528874324713456 48.5 35.528874324713456 54.5 29.528874324713456 48.5 3.5 48.5 C 0.5 48.5 0.5 48.5 0.5 45.5 L 0.5 3.5 C 0.5 0.5 0.5 0.5 3.5 0.5"
                            stroke-width="1" isShadow="true" stroke="black" stroke-opacity="0.15" transform="translate(1, 1)" width="71" height="48"></path>
                            <path fill="rgba(249, 249, 249, .85)" d="M 3.5 0.5 L 68.5 0.5 C 71.5 0.5 71.5 0.5 71.5 3.5 L 71.5 45.5 C 71.5 48.5 71.5 48.5 68.5 48.5 L 41.528874324713456 48.5 35.528874324713456 54.5 29.528874324713456 48.5 3.5 48.5 C 0.5 48.5 0.5 48.5 0.5 45.5 L 0.5 3.5 C 0.5 0.5 0.5 0.5 3.5 0.5"
                            stroke-width="1" stroke="#434348"></path>
                            <text x="8" zIndex="1" style="font-size:12px;color:#333333;fill:#333333;" y="21">
                                <tspan style="font-weight:bold">John</tspan>
                                <tspan x="8" dy="16">11 plums</tspan>
                            </text>
                        </g>
                        <text x="998" text-anchor="end" zIndex="8" style="cursor:pointer;color:#909090;font-size:9px;fill:#909090;" y="395">Highcharts.com</text>
                    </svg>
                </div>
            </div>

        </div>

        <!--Main content will be here-->
        <%@include file="/WEB-INF/jsp/template/footer.jsp" %>

