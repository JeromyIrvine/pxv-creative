$blockname = $Args[0]

$templatePath = ".\src\scripts\door"
$outputPath = ".\src\main\resources\assets\pxvblocks"

$bsDoor = "${outputPath}\blockstates\${blockname}_door.json"
$bmBottom = "${outputPath}\models\block\${blockname}_door_bottom.json"
$bmBottomRh = "${outputPath}\models\block\${blockname}_door_bottom_rh.json"
$bmTop = "${outputPath}\models\block\${blockname}_door_top.json"
$bmTopRh = "${outputPath}\models\block\${blockname}_door_top_rh.json"
$imDoor = "${outputPath}\models\item\${blockname}_door.json"

# Copy template files into place
Copy-Item ${templatePath}\blockstates_door.json             $bsDoor
Copy-Item ${templatePath}\blockmodel_door_bottom.json       $bmBottom
Copy-Item ${templatePath}\blockmodel_door_bottom_rh.json    $bmBottomRh
Copy-Item ${templatePath}\blockmodel_door_top.json          $bmTop
Copy-Item ${templatePath}\blockmodel_door_top_rh.json       $bmTopRh
Copy-Item ${templatePath}\itemmodel_door.json               $imDoor

# Replace template text
(Get-Content $bsDoor).Replace("<BLOCKNAME>", $blockname)        | Set-Content $bsDoor
(Get-Content $bmBottom).Replace("<BLOCKNAME>", $blockname)      | Set-Content $bmBottom
(Get-Content $bmBottomRh).Replace("<BLOCKNAME>", $blockname)    | Set-Content $bmBottomRh
(Get-Content $bmTop).Replace("<BLOCKNAME>", $blockname)         | Set-Content $bmTop
(Get-Content $bmTopRh).Replace("<BLOCKNAME>", $blockname)       | Set-Content $bmTopRh
(Get-Content $imDoor).Replace("<BLOCKNAME>", $blockname)        | Set-Content $imDoor
