//
//  Dot.swift
//  Sprouts
//
//  Created by Nolan Jimenez on 4/26/15.
//  Copyright (c) 2015 Akshay Srivatsan. All rights reserved.
//

import Foundation
import SpriteKit

class Dot : SKShapeNode {

    let radiusBall = 1;

    override init () {
        super.init();
        let path = CGPathCreateMutable();
        self.path = path;
        CGPathAddArc(path, nil, CGFloat(0), CGFloat(0), CGFloat(10), CGFloat(0), CGFloat(M_PI*2), true);
        self.lineWidth = 1.0;
        self.fillColor = SKColor.blueColor();
        self.strokeColor = SKColor.whiteColor();
        self.glowWidth = 0.5;
    }
    
    required override init!(coder : NSCoder) {
        super.init(coder: coder);
    }
    
}