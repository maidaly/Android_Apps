package com.example.android.tensorflow;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by Mai Daly on 4/30/2018.
 */

public class DrawRenderer {
    /**
     * Draw lines to canvas
     */
    //straight up drawing function to make the drawing visible to
    //the user. directly manipulates XML
    //given a canvas, a model drawing stored in memory, a color metadata,
    //start drawing!
    public static void renderModel(Canvas canvas, DrawModel model, Paint paint,
                                   int startLineIndex) {
        //minimize distortion artifacts
        paint.setAntiAlias(true);

        //get the size of the line to draw
        int lineSize = model.getLineSize();
        //given that size
        for (int i = startLineIndex; i < lineSize; ++i) {
            //get the whole line from the model object
            DrawModel.Line line = model.getLine(i);
            //set its color
            paint.setColor(Color.BLACK);
            //get the first of many lines that make up the overall line
            int elemSize = line.getElemSize();
            //if its empty, skip
            if (elemSize < 1) {
                continue;
            }
            // store that first line element in elem
            DrawModel.LineElem elem = line.getElem(0);
            //get its coordinates
            float lastX = elem.x;
            float lastY = elem.y;

            //for each coordinate in the line
            for (int j = 0; j < elemSize; ++j) {
                //get the next coordinate
                elem = line.getElem(j);
                float x = elem.x;
                float y = elem.y;
                //and draw the line between those two paints
                canvas.drawLine(lastX, lastY, x, y, paint);
                //store the coordinate as last and repeat
                //until the line is drawn
                lastX = x;
                lastY = y;
            }
        }
    }
}
