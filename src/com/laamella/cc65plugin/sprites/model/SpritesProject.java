package com.laamella.cc65plugin.sprites.model;

import java.util.ArrayList;
import java.util.List;

public class SpritesProject {
    public List<SingleSprite> sprites = new ArrayList<>();
    public List<Composition> compositions = new ArrayList<>();
    public boolean exportToRaw = false;
    public boolean exportToAssemblyFile = false;
    public boolean spriteEditorGrid = true;
    public boolean compositionEditorGrid = true;
}
