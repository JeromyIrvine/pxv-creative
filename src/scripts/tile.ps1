$blockname = $Args[0]

$templatePath = ".\src\scripts\tile"
$outputPath = ".\src\main\resources\assets\pxvblocks"

$bsTile = "${outputPath}\blockstates\${blockname}_tile.json"
$bmTile = "${outputPath}\models\block\${blockname}_tile.json"
$imTile = "${outputPath}\models\item\${blockname}_tile.json"

# Copy template files into place
Copy-Item ${templatePath}\blockstates_tile.json  $bsTile
Copy-Item ${templatePath}\blockmodel_tile.json   $bmTile
Copy-Item ${templatePath}\itemmodel_tile.json    $imTile

# Replace template text
(Get-Content $bsTile).Replace("<BLOCKNAME>", $blockname) | Set-Content $bsTile
(Get-Content $bmTile).Replace("<BLOCKNAME>", $blockname) | Set-Content $bmTile
(Get-Content $imTile).Replace("<BLOCKNAME>", $blockname) | Set-Content $imTile
