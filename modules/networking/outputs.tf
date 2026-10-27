
output "vpc_id" {
  description = "ID of the CloudForge VPC"
  value       = aws_vpc.main.id
}

output "public_subnet_id" {
  description = "ID of the CloudForge public subnet"
  value       = aws_subnet.public.id
}
