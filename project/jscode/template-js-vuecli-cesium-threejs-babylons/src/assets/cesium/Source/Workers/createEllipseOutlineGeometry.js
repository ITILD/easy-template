/* This file is automatically rebuilt by the Cesium build process. */
define(['./when-7be8a9d0', './Check-95b5c836', './Math-1bdfdd19', './Cartesian2-e1152338', './Transforms-48138b95', './RuntimeError-c01fec73', './WebGLConstants-daaa9be0', './ComponentDatatype-2d146d74', './GeometryAttribute-405802d4', './GeometryAttributes-1db6d1b2', './IndexDatatype-a017e02f', './GeometryOffsetAttribute-fe9a211c', './EllipseGeometryLibrary-654dc928', './EllipseOutlineGeometry-a3cd916f'], function (when, Check, _Math, Cartesian2, Transforms, RuntimeError, WebGLConstants, ComponentDatatype, GeometryAttribute, GeometryAttributes, IndexDatatype, GeometryOffsetAttribute, EllipseGeometryLibrary, EllipseOutlineGeometry) { 'use strict';

  function createEllipseOutlineGeometry(ellipseGeometry, offset) {
    if (when.defined(offset)) {
      ellipseGeometry = EllipseOutlineGeometry.EllipseOutlineGeometry.unpack(ellipseGeometry, offset);
    }
    ellipseGeometry._center = Cartesian2.Cartesian3.clone(ellipseGeometry._center);
    ellipseGeometry._ellipsoid = Cartesian2.Ellipsoid.clone(ellipseGeometry._ellipsoid);
    return EllipseOutlineGeometry.EllipseOutlineGeometry.createGeometry(ellipseGeometry);
  }

  return createEllipseOutlineGeometry;

});
