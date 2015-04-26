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

    let radiusBall =

    init () {
        self.path = CGPathCreateMutable();
        CGPathAddArc(self.path, nil, 0, 0, radiusBall, 0, M_PI*2, YES);
        self.lineWidth = 1.0;
        self.fillColor = SKColor.blueColor();
        self.strokeColor = SKColor.whiteColor();
        self.glowWidth = 0.5;
    }
    
}