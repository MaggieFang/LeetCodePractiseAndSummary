/* classes */

// Color constructor
class Color {

        // Color constructor default opaque black
    constructor(r=0,g=0,b=0,a=255) {
        try {
            if ((typeof(r) !== "number") || (typeof(g) !== "number") || (typeof(b) !== "number") || (typeof(a) !== "number"))
                throw "color component not a number";
            else if ((r<0) || (g<0) || (b<0) || (a<0))
                throw "color component less than 0";
            else if ((r>255) || (g>255) || (b>255) || (a>255))
                throw "color component bigger than 255";
            else {
                this.r = r; this.g = g; this.b = b; this.a = a;
            }
        } // end try

        catch (e) {
            console.log(e);
        }
    } // end Color constructor

        // Color change method
    change(r,g,b,a) {
        try {
            if ((typeof(r) !== "number") || (typeof(g) !== "number") || (typeof(b) !== "number") || (typeof(a) !== "number"))
                throw "color component not a number";
            else if ((r<0) || (g<0) || (b<0) || (a<0))
                throw "color component less than 0";
            else if ((r>255) || (g>255) || (b>255) || (a>255))
                throw "color component bigger than 255";
            else {
                this.r = r; this.g = g; this.b = b; this.a = a;
                return(this);
            }
        } // end throw

        catch (e) {
            console.log(e);
        }
    } // end Color change method

        // Color add method
    add(c) {
        try {
            if (!(c instanceof Color))
                throw "Color.add: non-color parameter";
            else {
                this.r += c.r; this.g += c.g; this.b += c.b; this.a += c.a;
                return(this);
            }
        } // end try

        catch(e) {
            console.log(e);
        }
    } // end color add

        // Color subtract method
    subtract(c) {
        try {
            if (!(c instanceof Color))
                throw "Color.subtract: non-color parameter";
            else {
                this.r -= c.r; this.g -= c.g; this.b -= c.b; this.a -= c.a;
                return(this);
            }
        } // end try

        catch(e) {
            console.log(e);
        }
    } // end color subgtract

        // Color scale method
    scale(s) {
        try {
            if (typeof(s) !== "number")
                throw "scale factor not a number";
            else {
                this.r *= s; this.g *= s; this.b *= s; this.a *= s;
                return(this);
            }
        } // end throw

        catch (e) {
            console.log(e);
        }
    } // end Color scale method

        // Color copy method
    copy(c) {
        try {
            if (!(c instanceof Color))
                throw "Color.copy: non-color parameter";
            else {
                this.r = c.r; this.g = c.g; this.b = c.b; this.a = c.a;
                return(this);
            }
        } // end try

        catch(e) {
            console.log(e);
        }
    } // end Color copy method

        // Color clone method
    clone() {
        var newColor = new Color();
        newColor.copy(this);
        return(newColor);
    } // end Color clone method

        // translate color to string
    toString() {
        return(this.r +" "+ this.g +" "+ this.b +" "+ this.a);
    }  // end Color toConsole

        // Send color to console
    toConsole() {
        console.log(this.toString());
    }  // end Color toConsole

} // end color class

// Vector class
class Vector {
    constructor(x,y,z) {
        this.set(x,y,z);
    } // end constructor

    // sets the components of a vector
    set(x,y,z) {
        try {
            if ((typeof(x) !== "number") || (typeof(y) !== "number") || (typeof(z) !== "number"))
                throw "vector component not a number";
            else
                this.x = x; this.y = y; this.z = z;
        } // end try

        catch(e) {
            console.log(e);
        }
    } // end vector set

    // copy the passed vector into this one
    copy(v) {
        try {
            if (!(v instanceof Vector))
                throw "Vector.copy: non-vector parameter";
            else
                this.x = v.x; this.y = v.y; this.z = v.z;
        } // end try

        catch(e) {
            console.log(e);
        }
    }

    toConsole(prefix="") {
        console.log(prefix+"["+this.x+","+this.y+","+this.z+"]");
    } // end to console

    // static dot method
    static dot(v1,v2) {
        try {
            if (!(v1 instanceof Vector) || !(v2 instanceof Vector))
                throw "Vector.dot: non-vector parameter";
            else
                return(v1.x*v2.x + v1.y*v2.y + v1.z*v2.z);
        } // end try

        catch(e) {
            console.log(e);
            return(NaN);
        }
    } // end dot static method

    // static cross method
    static cross(v1,v2) {
        try {
            if (!(v1 instanceof Vector) || !(v2 instanceof Vector))
                throw "Vector.cross: non-vector parameter";
            else {
                var crossX = v1.y*v2.z - v1.z*v2.y;
                var crossY = v1.z*v2.x - v1.x*v2.z;
                var crossZ = v1.x*v2.y - v1.y*v2.x;
                return(new Vector(crossX,crossY,crossZ));
            } // endif vector params
        } // end try

        catch(e) {
            console.log(e);
            return(NaN);
        }
    } // end dot static method

    // static add method
    static add(v1,v2) {
        try {
            if (!(v1 instanceof Vector) || !(v2 instanceof Vector))
                throw "Vector.add: non-vector parameter";
            else
                return(new Vector(v1.x+v2.x,v1.y+v2.y,v1.z+v2.z));
        } // end try

        catch(e) {
            console.log(e);
            return(new Vector(NaN,NaN,NaN));
        }
    } // end add static method

    // static subtract method, v1-v2
    static subtract(v1,v2) {
        try {
            if (!(v1 instanceof Vector) || !(v2 instanceof Vector))
                throw "Vector.subtract: non-vector parameter";
            else {
                var v = new Vector(v1.x-v2.x,v1.y-v2.y,v1.z-v2.z);
                return(v);
            }
        } // end try

        catch(e) {
            console.log(e);
            return(new Vector(NaN,NaN,NaN));
        }
    } // end subtract static method

    // static scale method
    static scale(c,v) {
        try {
            if (!(typeof(c) === "number") || !(v instanceof Vector))
                throw "Vector.scale: malformed parameter";
            else
                return(new Vector(c*v.x,c*v.y,c*v.z));
        } // end try

        catch(e) {
            console.log(e);
            return(new Vector(NaN,NaN,NaN));
        }
    } // end scale static method

    // static normalize method
    static normalize(v) {
        try {
            if (!(v instanceof Vector))
                throw "Vector.normalize: parameter not a vector";
            else {
                var lenDenom = 1/Math.sqrt(Vector.dot(v,v));
                return(Vector.scale(lenDenom,v));
            }
        } // end try

        catch(e) {
            console.log(e);
            return(new Vector(NaN,NaN,NaN));
        }
    } // end scale static method

} // end Vector class



/* utility functions */

// draw a pixel at x,y using color
function drawPixel(imagedata,x,y,color) {

    try {
        if ((typeof(x) !== "number") || (typeof(y) !== "number"))
            throw "drawpixel location not a number";
        else if ((x<0) || (y<0) || (x>=imagedata.width) || (y>=imagedata.height))
            throw "drawpixel location outside of image";
        else if (color instanceof Color) {
            var pixelindex = (y*imagedata.width + x) * 4;
            imagedata.data[pixelindex] = color.r;
            imagedata.data[pixelindex+1] = color.g;
            imagedata.data[pixelindex+2] = color.b;
            imagedata.data[pixelindex+3] = color.a;
        } else
            throw "drawpixel color is not a Color";
    } // end try

    catch(e) {
        drawPixel.numExcepts = (drawPixel.numExcepts == "undefined") ? 0 : drawPixel.numExcepts;
        if (drawPixel.numExcepts++ < 10)
            console.log(e);
    }
} // end drawPixel


/* application functions */

// interpolate and draw between two edges
// draws only in the y range occupied by both edges
// expects two edge parameters, each a two element array of vertex objects
// vertex objects have this structure: {x:float,y:float,c:Color}
function twoEdgeInterp(imagedata,e1,e2) {

    // create edge arrays for overlapping shared Y range
    var e1new = [[],[]], e2new = [[],[]];

    // ensure vertex with min y is first in each edge
    e1 = (e1[0].y < e1[1].y) ? e1 : e1.reverse();
    e2 = (e2[0].y < e2[1].y) ? e2 : e2.reverse();

    // find starting endpoints of edges with overlapping shared Y range
    var startYDiff = e1[0].y - e2[0].y;
    if (startYDiff > 0) { // e1 has largest min Y
        var startAtT = startYDiff/(e2[1].y - e2[0].y); // t at largest min Y
        e1new[0].x = e1[0].x; // set X at largest min Y in overlapping e1
        e1new[0].y = Math.ceil(e1[0].y); // set Y at largest min Y in overlapping e1
        e1new[0].c = e1[0].c.clone();  // set color at largest min Y in overlapping e1
        e2new[0].x = e2[0].x + (e2[1].x-e2[0].x) * startAtT; // set X in e2
        e2new[0].y = e1new[0].y; // set Y at largest min Y in overlapping e2 (same as e1)
        e2new[0].c = e2[1].c.clone().subtract(e2[0].c).scale(startAtT).add(e2[0].c);  // set color in e2
    } else { // end if e1 largest min Y, begin e2 largest min Y
        var startAtT = -startYDiff/(e1[1].y - e1[0].y); // t at largest min Y
        e2new[0].x = e2[0].x; // set X at largest min Y in overlapping e2
        e2new[0].y = Math.ceil(e2[0].y); // set Y at largest min Y in overlapping e2
        e2new[0].c = e2[0].c.clone();  // set color at largest min Y in overlapping e2
        e1new[0].x = e1[0].x + (e1[1].x-e1[0].x) * startAtT; // set X in e1
        e1new[0].y = e2new[0].y; // set Y at largest min Y in overlapping e1 (same as e2)
        e1new[0].c = e1[1].c.clone().subtract(e1[0].c).scale(startAtT).add(e1[0].c);  // set color in e1
    } // end if e2 has largest min Y

    // find ending endpoints of edges with overlapping shared Y range
    var endYDiff = e1[1].y - e2[1].y;
    if (endYDiff > 0) { // e1 has largest max Y
        var endAtT = -endYDiff/(e1[0].y - e1[1].y); // t at largest min Y
        e2new[1].x = e2[1].x; // set X at smallest max Y in e2
        e2new[1].y = e2[1].y; // set Y at smallest max Y in e2
        e2new[1].c = e2[1].c.clone(); // set color at smallest max Y in e2
        e1new[1].x = e1[1].x + (e1[0].x-e1[1].x) * endAtT;
        e1new[1].y = e2new[1].y; // set Y at smallest max Y in e1
        e1new[1].c = e1[0].c.clone().subtract(e1[1].c).scale(endAtT).add(e1[1].c);  // set color in e1
    } else { // end if e1 largest max Y, begin e2 largest max Y
        var endAtT = endYDiff/(e2[0].y - e2[1].y); // t at largest min Y
        e1new[1].x = e1[1].x; // set X at smallest max Y in e1
        e1new[1].y = e1[1].y; // set Y at smallest max Y in e1
        e1new[1].c = e1[1].c.clone(); // set color at smallest max Y in e1
        e2new[1].x = e2[1].x + (e2[0].x-e2[1].x) * endAtT;
        e2new[1].y = e1new[1].y; // set Y at smallest max Y in e2
        e2new[1].c = e2[0].c.clone().subtract(e2[1].c).scale(endAtT).add(e2[1].c);  // set color in e2
    } // end if e2 largest max Y

    // determine which overlapping edge is left, which is right
    try {
        const closeEnough = 0.000000001; // a billionth
        var startXComp = e1new[0].x-e2new[0].x;
        startXComp = (Math.abs(startXComp) > closeEnough) ? startXComp : 0;
        var endXComp = e1new[1].x-e2new[1].x;
        endXComp = (Math.abs(endXComp) > closeEnough) ? endXComp : 0;

        switch(Math.sign(startXComp) + Math.sign(endXComp)) {
            case -2: // both e1 endpoints are left of e2
            case -1: // one e1 endpoint left of e2 (other at same loc)
                var le = e1new, re = e2new; break;
            case 0: // one endpoint left of e2, other right. Error!
                throw "twoEdgeInterp: intersecting edges!"; break;
            case 1: // one e1 endpoint right of e2 (other at same loc)
            case 2: // both e1 endpoints are right of e2
                var le = e2new, re = e1new; break;
            default: // NaN or similar. Error!
                throw "twoEdgeInterp: NaN or similar!";
        } // end switch
    } // end try
    catch (e) {
        console.error(e); return;
    } // end catch

    // set up the vertical interpolation
    var vDelta = 1 / (e1new[1].y-e1new[0].y); // norm'd vertical delta
    var lcDelta = le[1].c.clone().subtract(le[0].c).scale(vDelta); // left vertical color delta
    var rcDelta = re[1].c.clone().subtract(re[0].c).scale(vDelta); // right vertical color delta
    var lxDelta = (le[1].x - le[0].x) * vDelta; // left vertical x delta
    var rxDelta = (re[1].x - re[0].x) * vDelta; // right vertical x delta
    var lx = le[0].x, rx = re[0].x; // init left/right x coord
    var lc = le[0].c.clone(), rc = re[0].c.clone(); // init left/right color

    // do the interpolation
    var hc = new Color(); // horizontal color
    var hcDelta = new Color(); // horizontal color delta
    for (var y=le[0].y; y<=le[1].y; y++) { // for each pixel row edges share
        hc.copy(lc); // begin with the left color
        hcDelta.copy(rc).subtract(lc).scale(1/(rx-lx)); // reset horiz color delta
        for (var x=Math.ceil(lx); x<=rx; x++) { // for each pixel in row
            drawPixel(imagedata,x,y,hc); // draw the color
            hc.add(hcDelta); // set next pixel color
        } // end horizontal
        lx += lxDelta; // set next left edge x coord
        rx += rxDelta; // set next right edge x coord
        lc.add(lcDelta); // set next left edge color
        rc.add(rcDelta); // set next right edge color
    } // end vertical
} // end twoEdgeInterp

// fills the passed 2d convex polygon
// expects an array of vertices, listed in clockwise order
// vertex objects have this structure: {x:float,y:float,c:Color}
function fillPoly(imagedata,vArray) {

    // sort the edges in the polygon by their min y coordinate
    // next remove any horizontal edges
    var minYList = vArray.map(function(vtx,idx,ary) { // create array of minY index pairs
        return({minY:Math.min(vtx.y,vArray[(idx+1)%vArray.length].y), index:idx});
    });
    minYList.sort(function(e1,e2) { // sort array by minY
        return(Math.sign(e1.minY-e2.minY));
    });
    var sortedNoHzEdges = minYList.filter(function (vtx,idx,ary) { // filter out horizontal edges
        return(vArray[vtx.index].y !== vArray[(vtx.index+1)%vArray.length].y);
    });

    // move through sorted edges, interpolating between each minY pair
    var e1 = 0, e2 = 1; // begin with first two edges (those that begin first/have min two Ys)
    var e1v1, e1v2, e2v1, e2v2; // the vertices included in these two edges
    while (e2<sortedNoHzEdges.length) { // for each polygon vertex index in sorted filtered list

        // set up the vertices in the current two edges
        e1v1 = vArray[sortedNoHzEdges[e1].index];
        e1v2 = vArray[(sortedNoHzEdges[e1].index+1)%vArray.length];
        e2v1 = vArray[sortedNoHzEdges[e2].index];
        e2v2 = vArray[(sortedNoHzEdges[e2].index+1)%vArray.length];

        // interpolate between the current two edges
        twoEdgeInterp(imagedata,[e1v1,e1v2],[e2v1,e2v2]);

        // discard the edge that ends first, or both if they end at same Y
        try {
            switch (Math.sign(Math.max(e1v1.y,e1v2.y)-Math.max(e2v1.y,e2v2.y))) {
                case -1: // e1 ends first
                    e1 = e2; break; // discard e1, save e2
                case 1: // e2 ends first
                    break; // save e1, discard e2
                case 0: // they end at same Y
                    e2++; e1 = e2; break; // discard both edges
                default: // something weird happened
                    throw "fillPoly: odd endpoint Y comparison. NaN?";
            } // end switch on which edge ends first
            e2++; // add new second edge
        } // end try

        catch (e) {
            console.error(e);
            break; // ... out of while loop
        } // end catch
    } // end for each polygon vertex index in sorted filtered list
} // end fillPoly

// projects the passed polygon using the passed viewing params
// expects a convex poly, as an array of vertices in clockwise order
// vertex objects have this structure: {x:float,y:float,z:float}
// expects a view description with this structure: {eye:Vector,
// at:Vector, up:Vector}. At is a vector, not a point.
// assumes 90 deg fov, places centered plane at distance of 1.
// returns altered x and y coords in vertex array
function projectPoly(imagedata,poly,view) {

    var eyePointSlope; // slope eye to point
    var denom, isectT; // denom of pixel t, t itself
    var ctrToIsect; // pixel world xyz less plane center

    var planeCenter = Vector.add(view.eye,Vector.normalize(view.at));
    var planeD = -Vector.dot(view.at,planeCenter);
    var num = -Vector.dot(view.at,view.eye) - planeD; // num of pixel t

    var planeX = Vector.normalize(Vector.cross(view.up,view.at));
    var planeY = Vector.normalize(Vector.cross(planeX,view.at));

    var w=imagedata.width, h=imagedata.height; // viewport size

    for (var v=0; v<poly.length; v++) { // for each poly vertex
        eyePointSlope = Vector.subtract(new Vector(poly[v].x,poly[v].y,poly[v].z),view.eye);
        denom = Vector.dot(view.at,eyePointSlope);

        try {
            if (denom == 0) // no intersection
                throw "projectPoly: one vertex doesn't intersect!";
            else { // intersection
                isectT = num / denom;
                if (isectT < 0) // one vertex behind eye
                    throw "one vertex behind eye!";
                else { // intersecton in front of eye
                    ctrToIsect = Vector.subtract(Vector.add(view.eye,Vector.scale(isectT,eyePointSlope)),planeCenter);
                    poly[v].x = Vector.dot(planeX,ctrToIsect)*w/2 + w/2; // project and viewport transform
                    poly[v].y = Vector.dot(planeY,ctrToIsect)*h/2 + h/2; // project onto planeY
                } // end if intersection behind plane
            } // end if intersects
        } // end try

        catch (e) {
            console.error(e);
            poly = []; // no projected poly
            break;
        } // end catch
    } // end for each poly vertex
} // end project poly


/* main -- here is where execution begins after window load */

function main() {

    // Get the canvas, context, and image data
    var canvas = document.getElementById("viewport");
    var context = canvas.getContext("2d");
    var w = context.canvas.width; // as set in html
    var h = context.canvas.height;  // as set in html
    var imagedata = context.createImageData(w,h);

    // define polygon and view
    var testEye = new Vector(0,0,0);
    var testAt = Vector.subtract(new Vector(0,0,10),testEye);
    var view = {eye:testEye, at:testAt, up:new Vector(0,1,0)};
    var poly = [{x:-5,y:5,z:10,c:new Color(255,0,0,255)}, {x:5,y:5,z:10,c:new Color(0,255,0,255)},
                {x:5,y:-5,z:10,c:new Color(0,0,0,255)}, {x:-5,y:-5,z:10,c:new Color(0,0,255,255)}];

    // Define and render a rectangle in 2D with colors and coords at corners
    projectPoly(imagedata,poly,view);
    fillPoly(imagedata,poly);

    context.putImageData(imagedata, 0, 0); // display the image in the context
}
