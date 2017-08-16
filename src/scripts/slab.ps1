$blockname = $Args[0]

$templatePath = ".\src\scripts\slab"
$outputPath = ".\src\main\resources\assets\pxvblocks"

$bsSlab = "${outputPath}\blockstates\${blockname}_slab.json"
$bsDouble = "${outputPath}\blockstates\${blockname}_slab_double.json"
$bmHalfSlab = "${outputPath}\models\block\${blockname}_half_slab.json"
$bmUpperSlab = "${outputPath}\models\block\${blockname}_upper_slab.json"
$imSlab = "${outputPath}\models\item\${blockname}_slab.json"

# Copy template files into place
Copy-Item ${templatePath}\blockstates_slab.json         $bsSlab
Copy-Item ${templatePath}\blockstates_slab_double.json  $bsDouble
Copy-Item ${templatePath}\blockmodel_half_slab.json     $bmHalfSlab
Copy-Item ${templatePath}\blockmodel_upper_slab.json    $bmUpperSlab
Copy-Item ${templatePath}\itemmodel_slab.json           $imSlab

# Replace template text
(Get-Content $bsSlab).Replace("<BLOCKNAME>", $blockname)        | Set-Content $bsSlab
(Get-Content $bsDouble).Replace("<BLOCKNAME>", $blockname)      | Set-Content $bsDouble
(Get-Content $bmHalfSlab).Replace("<BLOCKNAME>", $blockname)    | Set-Content $bmHalfSlab
(Get-Content $bmUpperSlab).Replace("<BLOCKNAME>", $blockname)   | Set-Content $bmUpperSlab
(Get-Content $imSlab).Replace("<BLOCKNAME>", $blockname)        | Set-Content $imSlab
