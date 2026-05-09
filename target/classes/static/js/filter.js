// <head>
//     <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
// </head>
// <body>
// <!-- your filters and content here -->
//
// <script>
//     $(document).ready(function () {
//     $('#equipmentSelect, #statusSelect, #fromDate, #toDate').on('change', function () {
//         fetchFilteredActivities();
//     });
//
//     function fetchFilteredActivities() {
//     $.ajax({
//     type: 'GET',
//     url: '/CMMS/report/filterActivities',
//     data: {
//     equipmentId: $('#equipmentSelect').val(),
//     status: $('#statusSelect').val(),
//     fromDate: $('#fromDate').val(),
//     toDate: $('#toDate').val()
// },
//     success: function (htmlFragment) {
//     $('#activityRowsContainer').html(htmlFragment);
// }
// });
// }
// });
// </script>
// </body>
//
// function fetchFilteredActivities() {
//     let asset = $('#asset').val();
//     let system = $('#system').val();
//     let subsystem = $('#subsystem').val();
//
//     // let status = $('#statusSelect').val();
//     // let fromDate = $('#fromDate').val();
//     // let toDate = $('#toDate').val();
//     let powerplant = $('#powerplant').val();
//
//
//     $.ajax({
//         type: 'GET',
//         url: '/CMMS/report/filterActivities',
//         data: {
//             powerplant: powerplant,
//             system: system,
//             subsystem: subsystem,
//             asset: asset
//             // equipmentId: equipmentId,
//             // status: status,
//             // fromDate: fromDate,
//             // toDate: toDate
//         },
//         success: function (htmlFragment) {
//             $('#activityRowsContainer').html(htmlFragment); // insert just <tr> rows
//         },
//         error: function () {
//             alert('Failed to filter activities.');
//         }
//     });
// }
//
//
// $('#equipmentSelect, #statusSelect, #fromDate, #toDate').on('change', fetchFilteredActivities);
