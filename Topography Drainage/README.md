This is an implementation of a solution for the following problem (An interview question given to me by a friend):

You have a 2D grid of non-negative integers respresenting a world map with heights. On this map there are two oceans represented by
contiguous areas of height 0. Using a reasonable definition of drainage, figure out which squares drain into each ocean.

(I took my definition of drainage to be: the map gradually fills with rain. A square drains into an ocean at height h if the least path from
that square to an ocean is of height, and the water drains along all drainage paths of this minium height.)
