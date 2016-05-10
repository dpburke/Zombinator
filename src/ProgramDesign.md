--V1.0.0 Design Philosophy and Notes
The Display package is intended to hold ONLY methods and classes that pertain to outputting things
all the states of objects and other game controllers are going to be done in the Engine package

The engine package is inteded to hold only things like cursor/selector tracking how to add and track 
and edit game objects 

The main package just holds the Zombinator code which will only start a Display passing the engine to 
it

The GameObjects will create an outline for different data types of objects please make sure all classes
extend from the baseGameObject class for conformities sake

We can refactor as needed but please try to track things like refactors and what not here
that way we can see refactors and stuff.. Please do not remove text from this file only add it on with
an updated version tag after discussing the severity of the version with the group.
--
--