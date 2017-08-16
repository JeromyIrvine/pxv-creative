$blockname = $Args[0]

$templatePath = ".\src\scripts\block"
$outputPath = ".\src\main\resources\assets\pxvblocks"

$bs = "${outputPath}\blockstates\${blockname}.json"
$bm = "${outputPath}\models\block\${blockname}.json"
$im = "${outputPath}\models\item\${blockname}.json"

# Copy template files into place
Copy-Item ${templatePath}\blockstates.json  $bs
Copy-Item ${templatePath}\blockmodel.json   $bm
Copy-Item ${templatePath}\itemmodel.json    $im

# Replace template text
(Get-Content $bs).Replace("<BLOCKNAME>", $blockname) | Set-Content $bs
(Get-Content $bm).Replace("<BLOCKNAME>", $blockname) | Set-Content $bm
(Get-Content $im).Replace("<BLOCKNAME>", $blockname) | Set-Content $im
