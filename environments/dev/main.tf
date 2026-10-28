
terraform {
  required_version = ">= 1.10.0"

  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~> 6.0"
    }
  }
}

provider "aws" {
  region = var.aws_region
}

module "networking" {
  source = "../../modules/networking"

  project_name       = var.project_name
  environment        = var.environment
  vpc_cidr           = var.vpc_cidr
  public_subnet_cidr = var.public_subnet_cidr
}
module "security" {
  source = "../../modules/security"

  project_name     = var.project_name
  environment      = var.environment
  vpc_id           = module.networking.vpc_id
  allowed_api_cidr = var.allowed_api_cidr
}

module "compute" {
  source = "../../modules/compute"

  project_name      = var.project_name
  environment       = var.environment
  subnet_id         = module.networking.public_subnet_id
  security_group_id = module.security.api_security_group_id
  instance_type     = "t3.micro"
}
